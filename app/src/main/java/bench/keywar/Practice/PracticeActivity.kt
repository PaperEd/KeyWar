package bench.keywar.Practice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import bench.keywar.Main.MainContract
import bench.keywar.Main.MainPresenter
import bench.keywar.R
import kotlinx.android.synthetic.main.activity_practice.*

/**
 * Created by dsm2017 on 2018-04-02.
 */
class PracticeActivity : AppCompatActivity() , MainContract.View {

    private val presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice)


        button.setOnClickListener { presenter.postUserString(edittext.text.toString()) }

        button2.setOnClickListener { presenter.getUserString() }
    }

}



