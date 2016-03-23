package fragments;

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

public class EazyFragment extends Fragment implements View.OnClickListener {

    private static final String LOG_TAG = EazyFragment.class.getSimpleName();
    private View view;
    private boolean secondFlip = false;
    private static final int NUMBER_OF_CARDS = 3;
    private static final int NUMBER_OF_LETTERS = 30;
    private int firstChosenImage;
    private int selectedView = -1;
    private List<Integer> pickedIds = new ArrayList<>();
    private ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6;
    private HashMap<Integer, Integer> setOfCardIds = new HashMap<>(NUMBER_OF_CARDS);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        imageButton1.setImageBitmap(Utilities.decodeSampledBitmapFromResource(getResources(),
                (Integer) Utilities.getIds().get(pickedIds.get(0)), imageButton1.getWidth(), imageButton1.getHeight()));
        setOfCardIds.put(0, pickedIds.get(0));
        imageButton2.setImageBitmap(Utilities.decodeSampledBitmapFromResource(getResources(),
                (Integer) Utilities.getIds().get(pickedIds.get(1)), imageButton2.getWidth(), imageButton2.getHeight()));
        setOfCardIds.put(1, pickedIds.get(1));
        imageButton3.setImageBitmap(Utilities.decodeSampledBitmapFromResource(getResources(),
                (Integer) Utilities.getIds().get(pickedIds.get(2)), imageButton3.getWidth(), imageButton3.getHeight()));
        setOfCardIds.put(2, pickedIds.get(2));
        Collections.shuffle(pickedIds);

        imageButton4.setImageBitmap(Utilities.decodeSampledBitmapFromResource(getResources(),
                (Integer) Utilities.getIds().get(pickedIds.get(0)), imageButton4.getWidth(), imageButton4.getHeight()));
        setOfCardIds.put(3, pickedIds.get(0));
        imageButton5.setImageBitmap(Utilities.decodeSampledBitmapFromResource(getResources(),
                (Integer) Utilities.getIds().get(pickedIds.get(1)), imageButton5.getWidth(), imageButton5.getHeight()));
        setOfCardIds.put(4, pickedIds.get(1));
        imageButton6.setImageBitmap(Utilities.decodeSampledBitmapFromResource(getResources(),
                (Integer) Utilities.getIds().get(pickedIds.get(2)), imageButton6.getWidth(), imageButton6.getHeight()));
        setOfCardIds.put(5, pickedIds.get(2));
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

    private void flipCard(int cardId, int imageViewId) {
        if (imageViewId != selectedView) {
            if (!secondFlip) {
                selectedView = imageViewId;
                firstChosenImage = cardId;
                Toast.makeText(getActivity(), "1 if", Toast.LENGTH_SHORT).show();
                secondFlip = true;
            } else if (secondFlip) {
                if (cardId == firstChosenImage) {
                    Toast.makeText(getActivity(), "2 if", Toast.LENGTH_SHORT).show();
                }
                secondFlip = false;
                selectedView = -1;
            }
        }else {
            Toast.makeText(getActivity(), "Pick another image", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        int imageId;
        switch (v.getId()) {
            case R.id.imageButton1:
                imageId = setOfCardIds.get(0);
                flipCard(imageId, v.getId());
                break;
            case R.id.imageButton2:
                imageId = setOfCardIds.get(1);
                flipCard(imageId, v.getId());
                break;
            case R.id.imageButton3:
                imageId = setOfCardIds.get(2);
                flipCard(imageId, v.getId());
                break;
            case R.id.imageButton4:
                imageId = setOfCardIds.get(3);
                flipCard(imageId, v.getId());
                break;
            case R.id.imageButton5:
                imageId = setOfCardIds.get(4);
                flipCard(imageId, v.getId());
                break;
            case R.id.imageButton6:
                imageId = setOfCardIds.get(5);
                flipCard(imageId, v.getId());
                break;
        }
    }
}