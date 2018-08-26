package com.example.asus.capturebugsbunny

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var score : Int = 0
    var imageArray = ArrayList<ImageView>()
    var handler : Handler = Handler()
    var runnable : Runnable = Runnable {  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        score = 0
        imageArray = arrayListOf(imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9)
        hideImages()


        //For counter - timer
        object: CountDownTimer(10000, 1000){
            override fun onFinish() {
                textTime.text = "Time's Off"
                handler.removeCallbacks(runnable) //for stop to runnable
                for (image in imageArray) //when end of the game, all images are invisible - Nno clikable
                    image.visibility = View.INVISIBLE


            }

            override fun onTick(millisUntilFinished: Long) {
                textTime.text = "Time : " + millisUntilFinished /1000

            }

        }.start()
    }

    fun hideImages(){

        runnable = object : Runnable {
            override fun run() {
                for (image in imageArray)
                    image.visibility = View.INVISIBLE


            //Select one of images, then make visible it
            val random = Random()
            val index = random.nextInt(8 - 0)
            imageArray[index].visibility = View.VISIBLE
                handler.postDelayed(runnable,500)
        }
    }
        handler.post(runnable)
    }

    fun increaseScore (view: View){ //this function for increases score when each click on images

        score++
        textScore.text = "Score: "+ score

    }
}
