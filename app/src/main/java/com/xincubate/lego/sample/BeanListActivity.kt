package com.xincubate.lego.sample

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.widget.TextView
import com.xincubate.lego.adapter.bean.BaseBeanAdapter
import com.xincubate.lego.adapter.bean.ItemBuilder
import com.xincubate.lego.adapter.core.BaseAdapter
import com.xincubate.lego.adapter.core.BaseItem
import com.xincubate.lego.adapter.core.BaseViewHolder
import com.xincubate.lego.annotation.LegoRegister
import com.xincubate.lego.layoutcenter.LayoutCenter
import kotlinx.android.synthetic.main.activity_main.*

class BeanListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        LayoutCenter.getInstance().registerItemBuilder(ListBean::class.java,object : ItemBuilder<ListBean>{
            override fun build(context: Context?, bean: ListBean?): BaseItem {
                return ListActivity.SimpleListItem(this@BeanListActivity,bean!!.index)
            }

        })

        title = "Bean列表"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(RecycleViewDivider(this, LinearLayoutManager.VERTICAL))

        val baseAdapter = BaseBeanAdapter(this)
        for (i in 1..100){
            baseAdapter.addBean(ListBean(i))
        }
        recyclerView.adapter = baseAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item!!.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


    data class ListBean(var index : Int)
}
