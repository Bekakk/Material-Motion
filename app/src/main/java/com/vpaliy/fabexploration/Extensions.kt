package com.vpaliy.fabexploration

import android.animation.ValueAnimator
import android.content.Context
import android.support.annotation.DimenRes
import android.support.v4.view.ViewCompat
import android.util.Log
import android.view.View

fun View.getHeightAnimator(endHeight:Int, duration:Long=200):ValueAnimator{
    val heightAnimator = ValueAnimator.ofInt(height, endHeight)
    heightAnimator.addUpdateListener {
        val value = it.animatedValue as Int
        layoutParams.height =value
        requestLayout()
    }
    heightAnimator.duration=duration
    return heightAnimator
}

fun View.getWidthAnimator(endWidth:Int, duration:Long=200):ValueAnimator{
    val widthAnimator = ValueAnimator.ofInt(width, endWidth)
    widthAnimator.addUpdateListener {
        val value = it.animatedValue as Int
        layoutParams.width =value
    }
    widthAnimator.duration=duration
    return widthAnimator
}

fun View.setHeight(endHeight: Int){
    layoutParams.height=endHeight
    requestLayout()
}

infix fun View.setElevation(@DimenRes id:Int){
    ViewCompat.setElevation(this,context.getDimensFloat(id))
}

fun Any.log(message:Any,tag:String=this.javaClass.name){
    Log.d(tag,message.toString())
}

fun View.click(function:()->Unit)=setOnClickListener { function() }

infix fun <T> Boolean.then(value:T)=if(this) value else null

infix fun Context.getDimens(id:Int)=resources.getDimensionPixelOffset(id)

infix fun Context.getDimensFloat(id:Int)=resources.getDimension(id)