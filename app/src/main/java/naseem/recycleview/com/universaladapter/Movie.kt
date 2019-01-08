package naseem.recycleview.com.universaladapter

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions






class Movie {

    var title: String? = null
    var genre: String? = null
    var year: String? = null

    var url: String? = null

    constructor(title: String, genre: String, year: String) {
        this.title = title
        this.genre = genre
        this.year = year
    }

    constructor(title: String, genre: String, year: String,url: String) {
        this.title = title
        this.genre = genre
        this.year = year
        this.url = url
    }


    companion object {
        @JvmStatic @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, url:String) {
            Glide.with(view)
                .load(url)
                .thumbnail(0.1f)

                .apply(RequestOptions().transforms(CenterCrop(), RoundedCorners(20)))

                .into(view)
        }
    }


}


