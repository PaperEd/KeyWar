package bench.keywar.Main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import bench.keywar.ChooseCount.ChooseCountDialog
import bench.keywar.Model.SingleSentenceModel
import bench.keywar.Practice.PracticeActivity
import bench.keywar.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {
    private val presenter: MainPresenter by lazy {
        MainPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        with(presenter) {
            main_btn_single.setOnClickListener {
                showDialog(true)
            }
        }
    }

    override fun showDialog(isSingle: Boolean) {
        val dialog = ChooseCountDialog(this)
        dialog.show()
        dialog.setOnDismissListener {
            if (!dialog.sentenceCount.isNullOrBlank()) {
                when (isSingle) {
                    true -> presenter.startSinglePlay(dialog.sentenceCount!!)
                    false -> TODO("멀티 연결부분 여기에 넣으세여~~")
                }
            }
        }
    }

    override fun startSingleActivity(singleSentenceModel: SingleSentenceModel) {
        val intent = Intent(baseContext, PracticeActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable("singleSentenceModel", singleSentenceModel)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    override fun showToast(content: String) {
        Toast.makeText(baseContext, content, Toast.LENGTH_SHORT).show()
    }

    override fun finishActivity() {
        finish()
    }
}

