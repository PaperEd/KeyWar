package bench.keywar.Main

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import android.widget.Toast
import bench.keywar.ChooseCount.ChooseCountDialog
import bench.keywar.Model.SingleSentenceModel
import bench.keywar.Practice.PracticeActivity
import bench.keywar.R

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
            main_btn_dual.setOnClickListener {
                showDualDialog()
            }
        }
    }


    override fun showDualDialog() {
        val dialog = Dialog(this)
        val intent = Intent(MainActivity@this, DualMakeSentenceActivity::class.java)
        dialog.setContentView(R.layout.dialog_sentence_count)
        dialog.show()

        dialog.sentence_count_10.setOnClickListener {
            intent.putExtra("count",10)
            startActivity(intent)
            dialog.dismiss()
        }

        dialog.sentence_count_20.setOnClickListener {
            intent.putExtra("count",20)
            startActivity(intent)
            dialog.dismiss()
        }

        dialog.sentence_count_30.setOnClickListener {
            intent.putExtra("count",30)
            startActivity(intent)
            dialog.dismiss()
        }

        dialog.setCanceledOnTouchOutside(true)

        var window  = dialog.window.apply { setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT) }
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

