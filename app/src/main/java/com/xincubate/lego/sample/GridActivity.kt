package com.xincubate.lego.sample

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.smarts.lego.adapter.core.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*

class GridActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        title = "网格列表"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView.layoutManager = GridLayoutManager(this,3)
        recyclerView.addItemDecoration(RecycleViewDivider(this, LinearLayoutManager.VERTICAL))
        recyclerView.addItemDecoration(RecycleViewDivider(this, LinearLayoutManager.HORIZONTAL))

        val baseAdapter = BaseAdapter(this)
        for (i in 1..100){
            baseAdapter.addItem(ListActivity.SimpleListItem(this, i))
        }
        recyclerView.adapter = baseAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item!!.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
