package tw.edu.pu.csim.tcyang.yokai2

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import tw.edu.pu.csim.tcyang.yokai2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnTouchListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.img1.setOnTouchListener(this)
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_MOVE){
            v?.x = event!!.rawX - v!!.width/2
            v?.y = event!!.rawY - v!!.height/2

            var rMove: Rect = Rect(v.x.toInt(), v.y.toInt(),
                v.x.toInt() + v.width, v.y.toInt() + v.height)
            var rTarget: Rect = Rect(binding.img2.x.toInt(), binding.img2.y.toInt(),
                binding.img2.x.toInt() + binding.img2.width,
                binding.img2.y.toInt() + binding.img2.height)

            if(rMove.intersect(rTarget)) {
                binding.txv.text = "碰撞"
            }
            else{
                binding.txv.text = ""
            }

        }

        return true
    }
}