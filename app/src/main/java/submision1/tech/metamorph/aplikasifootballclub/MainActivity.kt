package submision1.tech.metamorph.aplikasifootballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import submision1.tech.metamorph.aplikasifootballclub.R.array.*
import submision1.tech.metamorph.aplikasifootballclub.adapters.RecyclerTeamAdapter
import submision1.tech.metamorph.aplikasifootballclub.models.Team

class MainActivity : AppCompatActivity() {

    private var items : MutableList<Team> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = RecyclerTeamAdapter(this, items) {itemClickListener(it)}

    }

    private fun initData(){
        val name = resources.getStringArray(club_name)
        val image = resources.obtainTypedArray(club_image)
        val description = resources.getStringArray(club_description)
        items.clear()
        for (i in name.indices) {
            items.add(Team(name[i],
                    image.getResourceId(i, 0), description[i]))
        }

        image.recycle()
    }

    private fun itemClickListener(items: Team) {
        startActivity<DetailActivity>(DetailActivity.CLUB_NAME to items.name, DetailActivity.CLUB_IMAGE to items.image, DetailActivity.CLUB_DESCRIPTION to items.description)
    }

}
