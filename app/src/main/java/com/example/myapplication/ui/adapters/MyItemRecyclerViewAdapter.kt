package com.example.myapplication.ui.adapters

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.Target
import com.example.myapplication.data.model.ApiData
import com.example.myapplication.data.model.User
import com.example.myapplication.databinding.FragmentUserTileBinding
import com.example.myapplication.ui.fragments.UserListFragmentDirections


class MyItemRecyclerViewAdapter(
    private val values: ApiData
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    lateinit var parent: ViewGroup;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.parent = parent

        return ViewHolder(
            FragmentUserTileBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        try {
            val item = values.users[position]
            holder.binding.name.text = item.firstName
            holder.binding.Age.text = item.age.toString() + " years"
            holder.binding.email.text = item.email
            holder.binding.Phone.text = item.phone

            setImage(item, holder.binding);
            holder.binding.root.setOnClickListener {
                val navController = Navigation.findNavController(it)
                navController.navigate(
                    UserListFragmentDirections.actionItemFragmentToBlankFragment(
                        values.users[position]
                    )
                );
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun setImage(user: User, binding: FragmentUserTileBinding) {
        LoadCircleImageIntoImageView(binding.root.context, user, binding.displayPicture)
    }


    /**
     * This function will load the image into imageview using picasso library and also transform the image to circle using the CircleTranform method
     *
     * @param mContext  -- Context of activity
     * @param resId     -- Int ( Image Resource Id)
     * @param imageView -- Imageview to which image is to be loaded
     */
    fun LoadCircleImageIntoImageView(mContext: Context, user: User, imageView: ImageView) {
        try {
            // set shape of the image and divider line
            // set oval shape of the image stroke border
            val gradientDrawable = GradientDrawable()
            // SHape == 1 means Oval Shape
            gradientDrawable.shape = GradientDrawable.OVAL
            gradientDrawable.setStroke(2, Color.parseColor("#737373"))
            imageView.setBackground(gradientDrawable)
            (mContext as Activity).runOnUiThread {
                // using glide library to set image into image view
                Glide.with(mContext)
                    .load(user.image)
                    .circleCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(
                        imageView
                    )
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }


    override fun getItemCount(): Int =
        values.users.size

    inner class ViewHolder(val binding: FragmentUserTileBinding) :
        RecyclerView.ViewHolder(binding.root) {


    }

}