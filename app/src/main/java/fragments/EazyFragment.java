package fragments;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.sinisa.slovarica.R;
import com.sinisa.slovarica.Utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class EazyFragment extends Fragment implements View.OnClickListener{

    private static final String LOG_TAG = EazyFragment.class.getSimpleName();
    private View view;
    private boolean secondFlip = false;
    private static final int NUMBER_OF_CARDS = 3;
    private static final int NUMBER_OF_LETTERS = 30;
    private int firstChosenImage;
    private int firstSelectedView = -1;
    private int correctHits = 0;
    private SoundPool soundPool;
    private int rightAnswer, wrongAnswer,gameOver, gameWin;
    private boolean loaded;
    private List<Integer> pickedIds = new ArrayList<>();
    private ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6;
    private HashMap<Integer, Integer> setOfCardIds = new HashMap<>(NUMBER_OF_CARDS);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;
            }
        });
        rightAnswer = soundPool.load(getActivity(), R.raw.wrong_answer,1);
        wrongAnswer = soundPool.load(getActivity(), R.raw.right_answer,1);
        gameWin = soundPool.load(getActivity(), R.raw.game_win,1);
        gameOver = soundPool.load(getActivity(), R.raw.game_over,1);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_eazy, container, false);

        setReferences(view);
        shuffleCards();

        return view;
    }

    private void shuffleCards() {
        Random random = new Random();

        outer:
        for (int i = 0; true; i++) {
            int indexOfMapOfId = random.nextInt(NUMBER_OF_LETTERS);
            if (pickedIds.isEmpty() || !pickedIds.contains(indexOfMapOfId)) {
                pickedIds.add(indexOfMapOfId);
            }
            if (pickedIds.size() == NUMBER_OF_CARDS) {
                break outer;
            }
        }
        Collections.shuffle(pickedIds);
        imageButton1.setImageResource((Integer) Utilities.getIdsPlaying().get(pickedIds.get(0)));
        setOfCardIds.put(0, pickedIds.get(0));
        imageButton2.setImageResource((Integer) Utilities.getIdsPlaying().get(pickedIds.get(1)));
        setOfCardIds.put(1, pickedIds.get(1));
        imageButton3.setImageResource((Integer) Utilities.getIdsPlaying().get(pickedIds.get(2)));
        setOfCardIds.put(2, pickedIds.get(2));
        Collections.shuffle(pickedIds);
        imageButton4.setImageResource((Integer) Utilities.getIdsPlaying().get(pickedIds.get(0)));
        setOfCardIds.put(3, pickedIds.get(0));
        imageButton5.setImageResource((Integer) Utilities.getIdsPlaying().get(pickedIds.get(1)));
        setOfCardIds.put(4, pickedIds.get(1));
        imageButton6.setImageResource((Integer) Utilities.getIdsPlaying().get(pickedIds.get(2)));
        setOfCardIds.put(5, pickedIds.get(2));

    }


    private void flipCard(int cardId, int imageViewId) {
        if (imageViewId != firstSelectedView) {
            if (!secondFlip) {
                firstSelectedView = imageViewId;
                firstChosenImage = cardId;
                secondFlip = true;
            } else if (secondFlip) {
                if (cardId == firstChosenImage) {
                    correctHits++;
                    if (loaded && correctHits<3){
                        soundPool.play(rightAnswer,1,1,0,0,1);
                    }
                    ImageButton newImageButton = (ImageButton) view.findViewById(imageViewId);
                    newImageButton.setVisibility(View.INVISIBLE);
                    ImageButton newImageButton2 = (ImageButton) view.findViewById(firstSelectedView);
                    newImageButton2.setVisibility(View.INVISIBLE);
                    if (correctHits == 3){
                        if (loaded){
                            soundPool.play(gameWin,1,1,0,0,1);
                        }
                        Toast.makeText(getActivity(), "You win 100 points", Toast.LENGTH_SHORT).show();
                        getActivity().finish();
                    }
                }else {
                    if (loaded){
                        soundPool.play(wrongAnswer,1,1,0,0,1);
                    }
                }
                secondFlip = false;
                firstSelectedView = -1;
            }
        } else {
            Toast.makeText(getActivity(), "Pick another image", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        int cardId;
        switch (v.getId()) {
            case R.id.imageButton1:
                cardId = setOfCardIds.get(0);
                flipCard(cardId, v.getId());
                break;
            case R.id.imageButton2:
                cardId = setOfCardIds.get(1);
                flipCard(cardId, v.getId());
                break;
            case R.id.imageButton3:
                cardId = setOfCardIds.get(2);
                flipCard(cardId, v.getId());
                break;
            case R.id.imageButton4:
                cardId = setOfCardIds.get(3);
                flipCard(cardId, v.getId());
                break;
            case R.id.imageButton5:
                cardId = setOfCardIds.get(4);
                flipCard(cardId, v.getId());
                break;
            case R.id.imageButton6:
                cardId = setOfCardIds.get(5);
                flipCard(cardId, v.getId());
                break;
        }
    }
    private void setReferences(View v) {
        imageButton1 = (ImageButton) v.findViewById(R.id.imageButton1);
        imageButton2 = (ImageButton) v.findViewById(R.id.imageButton2);
        imageButton3 = (ImageButton) v.findViewById(R.id.imageButton3);
        imageButton4 = (ImageButton) v.findViewById(R.id.imageButton4);
        imageButton5 = (ImageButton) v.findViewById(R.id.imageButton5);
        imageButton6 = (ImageButton) v.findViewById(R.id.imageButton6);

        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);
        imageButton4.setOnClickListener(this);
        imageButton5.setOnClickListener(this);
        imageButton6.setOnClickListener(this);
    }
}