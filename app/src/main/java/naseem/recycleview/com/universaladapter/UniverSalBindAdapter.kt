package com.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import naseem.recycleview.com.universaladapter.BR


import naseem.recycleview.com.universaladapter.R


/**
 * Created by naseem on 28/11/17.
 */

class UniverSalBindAdapter(): RecyclerView.Adapter< RecyclerView.ViewHolder>() {


    override fun getItemViewType(position: Int): Int {
        return if (position == arrraylist!!.size - 1 && isLoadingAdded) LOADING else ITEM

    }
    var type=""
    var layout:Int = 0

    constructor(layout:Int) :this() {

        this.layout=layout;
    }
     constructor(layout:Int,type:String) :this() {
         this.layout=layout;
        this.type=type;
    }

    override fun getItemCount(): Int {

        return if (arrraylist == null) 0 else arrraylist!!.size
    }

    private var isLoadingAdded = false
    private var retryPageLoad = false

    fun addLoadingFooter( any: Any) {
        isLoadingAdded = true
        add(any)
    }

    fun removeLoadingFooter() {
        isLoadingAdded = false

        val position = arrraylist!!.size - 1
        val result = getItem(position)

        if (result != null&&position!=-1) {
            arrraylist!!.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    var arrraylist=ArrayList<Any>()

    fun getItem(position: Int): Any? {
        return arrraylist!![position]
    }

    fun add(r: Any,position: Int) {
        arrraylist!!.add(position,r)

        notifyItemInserted(position)
    }

    fun add(r: Any) {
        arrraylist!!.add(r)

        notifyItemInserted(arrraylist!!.size - 1)
    }

    fun addAll(arrraylist: ArrayList<Any>) {
        for (result in arrraylist) {
            add(result)
        }
    }





    override fun onBindViewHolder(parent:  RecyclerView.ViewHolder, p1: Int) {


        when (getItemViewType(p1)) {



            ITEM -> {
                if (parent != null) {





                    val vh = parent as MYViewHolder

                        parent.databinding.setVariable(BR.user,arrraylist.get(p1))
                        parent.databinding.executePendingBindings()




                }

            }


            LOADING -> {
                val loadingVH = parent as LoadingVH

                if (retryPageLoad) {
                    loadingVH.mErrorLayout.visibility = View.VISIBLE
                    loadingVH.mProgressBar.visibility = View.GONE

                    loadingVH.mErrorTxt.text = if (errorMsg != null)
                        errorMsg
                    else
                       "An unexpected error occurred"

                } else {
                    loadingVH.mErrorLayout.visibility = View.GONE
                    loadingVH.mProgressBar.visibility = View.VISIBLE
                }
            }


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int):  RecyclerView.ViewHolder  {


        var viewHolder: RecyclerView.ViewHolder? = null
        val inflater = LayoutInflater.from(parent!!.context)

        when (p1) {
            ITEM -> {

                var     databinding:ViewDataBinding =  DataBindingUtil.inflate(inflater,layout, parent, false)



                viewHolder= MYViewHolder(databinding.root,databinding)

            }
            LOADING -> {

                val viewLoading = inflater.inflate(R.layout.item_progress, parent, false)
                viewHolder = LoadingVH(viewLoading)
            }

        }
        return viewHolder!!









    }


    protected inner class LoadingVH(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val mProgressBar: ProgressBar
        val mRetryBtn: ImageButton
        val mErrorTxt: TextView
        val mErrorLayout: LinearLayout

        init {

            mProgressBar = itemView.findViewById<ProgressBar>(R.id.loadmore_progress) as ProgressBar
            mRetryBtn = itemView.findViewById<ImageButton>(R.id.loadmore_retry) as ImageButton
            mErrorTxt = itemView.findViewById(R.id.loadmore_errortxt)
            mErrorLayout = itemView.findViewById<LinearLayout>(R.id.loadmore_errorlayout) as LinearLayout

            mRetryBtn.setOnClickListener(this)
            mErrorLayout.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            when (view.id) {
                R.id.loadmore_retry, R.id.loadmore_errorlayout -> {

                    showRetry(false, null)
                    //mCallback.retryPageLoad()
                }
            }
        }
    }

    class MYViewHolder(view: View,databinding: ViewDataBinding) : RecyclerView.ViewHolder(view) {

       var databinding=databinding


    }
    fun showRetry(show: Boolean, errorMsg: String?) {
        retryPageLoad = show
        notifyItemChanged(arrraylist!!.size - 1)

        if (errorMsg != null) this.errorMsg = errorMsg
    }

    private var errorMsg: String? = null

    companion object {

        // View Types
        private val ITEM = 0
        private val LOADING = 1
        private val HERO = 2

        private val BASE_URL_IMG = "https://image.tmdb.org/t/p/w150"
    }

}
