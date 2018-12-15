package com.xincubate.lego.sample

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.widget.TextView
import com.xincubate.lego.adapter.core.BaseAdapter
import com.xincubate.lego.adapter.core.BaseItem
import com.xincubate.lego.adapter.core.BaseViewHolder
import com.xincubate.lego.annotation.LegoRegister
import com.xincubate.lego.layoutcenter.LayoutCenter
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
