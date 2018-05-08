package bench.keywar.ChooseCount

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import bench.keywar.Connect.Connector
import bench.keywar.R
import kotlinx.android.synthetic.main.dialog_choose_count.*

/**
 * Created by PaperEd on 2018-04-16.
 */
class ChooseCountDialog(context: Context) : Dialog(context) {

    var sentenceCount: String? = null
    lateinit var sentences: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
        setContentView(R.layout.dialog_choose_count)

        with(ChooseCountPresenter()) {
            chooseCount_btn_10.setOnClickListener {
                sentenceCount = "10"
                dismiss()
            }

            chooseCount_btn_20.setOnClickListener {
                sentenceCount = "20"
                dismiss()
            }

            chooseCount_btn_30.setOnClickListener {
                sentenceCount = "30"
                dismiss()
            }
        }
    }
}