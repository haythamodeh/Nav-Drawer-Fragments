package com.example.navdrawerfragments.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.navdrawerfragments.R;
import com.example.navdrawerfragments.databinding.FragmentHomeBinding;
import com.example.navdrawerfragments.ui.gallery.GalleryFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    FragmentManager fm;

    Button mGallery1;
    Button mGallery2;
    Button mGallery3;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home,container,false);
        //TODO: Sets the onClickListener for each button to the galleryItemButtonClick method with appropriate arguments

        mGallery1 = (Button) root.findViewById(R.id.galleryItem1_btn);
        mGallery2 = (Button) root.findViewById(R.id.galleryItem2_btn);
        mGallery3 = (Button) root.findViewById(R.id.galleryItem3_btn);

        mGallery1.setOnClickListener(v -> {
            galleryItemButtonClick(v, 1);
        });
        mGallery2.setOnClickListener(v -> {
            galleryItemButtonClick(v, 2);
        });
        mGallery3.setOnClickListener(v -> {
            galleryItemButtonClick(v, 3);
        });

        return root;
    }

    public void galleryItemButtonClick(View view, int item){
        HomeFragmentDirections.ActionNavHomeToNavGallery action = HomeFragmentDirections.actionNavHomeToNavGallery();
        //TODO: assign the appropriate item number value to the Destination Argument and navigate to the gallery page
        action.setGalleryItemId(item);
        NavHostFragment.findNavController(HomeFragment.this).navigate(action);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}