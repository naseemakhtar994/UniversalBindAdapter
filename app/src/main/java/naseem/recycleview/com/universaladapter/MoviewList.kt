package naseem.recycleview.com.universaladapter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.adapter.UniverSalBindAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MoviewList  : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleveiw.layoutManager= LinearLayoutManager(this)
        recycleveiw.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        var adapter= UniverSalBindAdapter(R.layout.row_moview_list)
        recycleveiw.adapter = adapter
        adapter.addLoadingFooter(Any())
        prepareMovieData()
        adapter.removeLoadingFooter()
        adapter.addAll(movieList as ArrayList<Any>)
    }



    private var movieList=ArrayList<Movie>()
    private fun prepareMovieData() {
        var movie = Movie("Mad Max: Fury Road", "Action & Adventure", "2015","http://i0.wp.com/pop-critica.com/wp-content/uploads/2015/04/mad-max-fury-road-poster-040515.jpg?resize=150%2C150")
        movieList.add(movie)

        movie = Movie("Inside Out", "Animation, Kids & Family", "2015","http://www.gstatic.com/tv/thumb/v22vodart/10840532/p10840532_v_v8_ak.jpg")
        movieList.add(movie)

        movie = Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015","http://www.gstatic.com/tv/thumb/v22vodart/10989070/p10989070_v_v8_ab.jpg")
        movieList.add(movie)

        movie = Movie("Shaun the Sheep", "Animation", "2015","http://www.gstatic.com/tv/thumb/tvbanners/11117029/p11117029_b_v8_aa.jpg")
        movieList.add(movie)

        movie = Movie("The Martian", "Science Fiction & Fantasy", "2015","http://www.gstatic.com/tv/thumb/v22vodart/10980706/p10980706_v_v8_ab.jpg")
        movieList.add(movie)

        movie = Movie("Mission: Impossible Rogue Nation", "Action", "2015","http://www.gstatic.com/tv/thumb/v22vodart/10989210/p10989210_v_v8_at.jpg")
        movieList.add(movie)

        movie = Movie("Up", "Animation", "2009","http://www.gstatic.com/tv/thumb/v22vodart/190662/p190662_v_v8_ay.jpg")
        movieList.add(movie)

        movie = Movie("Star Trek", "Science Fiction", "2009","https://www.idwpublishing.com/wp-content/uploads/2014/10/StarTrek_NewAdventures_v1-lo.jpg")
        movieList.add(movie)

        movie = Movie("The LEGO Movie", "Animation", "2014","http://www.gstatic.com/tv/thumb/v22vodart/10106164/p10106164_v_v8_au.jpg")
        movieList.add(movie)

        movie = Movie("Iron Man", "Action & Adventure", "2008","http://www.gstatic.com/tv/thumb/v22vodart/170620/p170620_v_v8_al.jpg")
        movieList.add(movie)

        movie = Movie("Aliens", "Science Fiction", "1986","http://www.gstatic.com/tv/thumb/v22vodart/9384/p9384_v_v8_aa.jpg")
        movieList.add(movie)

        movie = Movie("Chicken Run", "Animation", "2000","http://www.gstatic.com/tv/thumb/v22vodart/24668/p24668_v_v8_ab.jpg")
        movieList.add(movie)

        movie = Movie("Back to the Future", "Science Fiction", "1985","http://www.gstatic.com/tv/thumb/v22vodart/8717/p8717_v_v8_ab.jpg")
        movieList.add(movie)

        movie = Movie("Raiders of the Lost Ark", "Action & Adventure", "1981","http://www.gstatic.com/tv/thumb/v22vodart/7719/p7719_v_v8_ae.jpg")
        movieList.add(movie)

        movie = Movie("Goldfinger", "Action & Adventure", "1965","http://www.gstatic.com/tv/thumb/v22vodart/3374/p3374_v_v8_ab.jpg")
        movieList.add(movie)

        movie = Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014","http://www.gstatic.com/tv/thumb/v22vodart/10108283/p10108283_v_v8_aj.jpg")
        movieList.add(movie)


    }
}

