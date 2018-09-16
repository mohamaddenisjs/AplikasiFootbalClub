package submision1.tech.metamorph.aplikasifootballclub

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {


    companion object {
        const val CLUB_NAME = "club_name"
        const val CLUB_IMAGE = "club_image"
        const val CLUB_DESCRIPTION = "club_description"
    }


    private var club_name: String = ""
    private var club_image: Int = 0
    private var club_desc: String = ""

    lateinit var clubNameTextView: TextView
    lateinit var clubImageView: ImageView
    lateinit var club_descTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            padding = dip(16)

            clubImageView = imageView()
                    .lparams(width = dip(100), height = dip(120)) {
                        gravity = Gravity.CENTER
                    }
            clubNameTextView = textView {
                textSize = 18f
                typeface = Typeface.createFromAsset(context.assets, "fonts/open_sans_bold.ttf")

            }
                    .lparams(width = wrapContent) {
                        gravity = Gravity.CENTER
                        topMargin = dip(10)
                    }

            club_descTextView = textView{
                textSize = 14f
                typeface = Typeface.createFromAsset(context.assets, "fonts/open_sans_semibold.ttf")
            }
                    .lparams(width = wrapContent) {
                        gravity = Gravity.CENTER
                        topMargin = dip(10)
                        leftMargin = dip(16)
                        rightMargin = dip(16)
                    }
        }

        club_image = intent.getIntExtra(CLUB_IMAGE, 0)
        club_name = intent.getStringExtra(CLUB_NAME)
        club_desc = intent.getStringExtra(CLUB_DESCRIPTION)

        Glide.with(clubImageView).load(club_image).into(clubImageView)
        clubNameTextView.text = club_name
        club_descTextView.text = club_desc

    }
}