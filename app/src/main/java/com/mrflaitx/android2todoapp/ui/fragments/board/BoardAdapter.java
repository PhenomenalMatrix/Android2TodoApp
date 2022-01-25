package com.mrflaitx.android2todoapp.ui.fragments.board;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrflaitx.android2todoapp.R;
import com.mrflaitx.android2todoapp.databinding.ItemBoardBinding;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {

    private final int[] images = {
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_background};
    private final String[] title = {"Title1", "Title2", "Title3"};
    private final String[] subtitle = {"SubTitle1", "SubTitle2", "SubTitle3"};
    private ItemBoardBinding binding;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_board,
//                parent,
//                false);
//        return new ViewHolder(view);
        binding = ItemBoardBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,
                false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(images[position],title[position],subtitle[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull ItemBoardBinding binding) {
            super(binding.getRoot());
        }

        public void onBind(int image, String title, String subTitle) {
            binding.boardIv.setImageResource(image);
            binding.boardTitleTv.setText(title);
            binding.boardSubtitleTv.setText(subTitle);
        }
    }

}
