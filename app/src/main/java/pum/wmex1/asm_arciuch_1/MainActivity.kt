package pum.wmex1.asm_arciuch_1

import android.animation.ObjectAnimator
import android.graphics.Color
import android.graphics.Path
import android.graphics.RectF
import android.graphics.drawable.Drawable
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.core.view.isVisible
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var b1 : Button
    private lateinit var t1: TextView
    private lateinit var l1: LinearLayout
    private lateinit var e1: EditText
    private lateinit var im1 : ImageView
    private lateinit var im2 : ImageView

    private var i : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        t1 = findViewById(R.id.textView)
        b1 = findViewById(R.id.button)
        l1 = findViewById(R.id.l1)
        e1 = findViewById(R.id.editText)
        im1 = findViewById(R.id.image)
        im2 = findViewById(R.id.image2)

        im1.visibility = View.VISIBLE
        im2.visibility = View.GONE

        l1.setBackgroundColor(Color.rgb(0, 0, 0))
        t1.setBackgroundColor(Color.rgb(0, 255, 0))
        e1.setBackgroundColor(Color.rgb(0, 255, 255))
        b1.setBackgroundColor(Color.rgb(255, 255, 255))

        b1.setOnClickListener {
            if (++i % 2 == 1) {
                l1.setBackgroundColor(Color.rgb(0, 0, 255))
                t1.setBackgroundColor(Color.rgb(255, 0, 0))
                t1.text = Date().toString()
                e1.setBackgroundColor(Color.rgb(255, 255, 0))
                b1.setBackgroundColor(Color.rgb(255, 0, 255))
                im1.visibility = View.VISIBLE
                im2.visibility = View.VISIBLE
                starAnim(im1,1)
                starAnim(im2,2)

            } else {
                l1.setBackgroundColor(Color.rgb(0, 0, 0))
                t1.setBackgroundColor(Color.rgb(0, 255, 0))
                e1.setBackgroundColor(Color.rgb(0, 255, 255))
                b1.setBackgroundColor(Color.rgb(255, 255, 255))
                t1.text = e1.text.toString()
                im1.visibility = View.GONE
                im2.visibility = View.VISIBLE
                starAnim(im2,2)
            }
        }
    }

    private fun starAnim(v: View, num: Int) {
        var anim : Animation? = null
        when (num) {
            1 -> {
                anim = AnimationUtils.loadAnimation(applicationContext, R.anim.anim1)
            }
            2 -> {
                anim = AnimationUtils.loadAnimation(applicationContext, R.anim.anim2)
            }
        }
        v.startAnimation(anim)


//        val path = Path()
//        path.moveTo(0F, 0F)
//        path.arcTo(RectF(300F, 400F, 300F, 800F), -180F, 180F, true)
//        val animator = ObjectAnimator.ofFloat(v, View.TRANSLATION_X, View.TRANSLATION_Y, path)
//        animator.duration = 1000
//        animator.startDelay = 1000
//        animator.start()


    }
}