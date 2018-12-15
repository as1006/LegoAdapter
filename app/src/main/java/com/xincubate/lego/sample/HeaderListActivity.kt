package com.xincubate.lego.sample

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.widget.TextView
import com.xincubate.lego.adapter.core.BaseAdapter
import com.xincubate.lego.adapter.core.BaseItem
import com.xincubate.lego.adapter.core.BaseViewHolder
import com.xincubate.lego.annotation.LegoRegister
import com.xincubate.lego.layoutcenter.LayoutCenter
import kotlinx.android.synthetic.main.activity_main.*

class HeaderListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        title = "线性列表(包含Header和Footer)"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(RecycleViewDivider(this, LinearLayoutManager.VERTICAL))

        val baseAdapter = BaseAdapter(this)
        for (i in 1..20){
            baseAdapter.addItem(ListActivity.SimpleListItem(this, i))
        }
        baseAdapter.addHeaderItem(HeaderItem(this))
        baseAdapter.addFooterItem(HeaderItem(this))
        recyclerView.adapter = baseAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item!!.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    @LegoRegister
    class HeaderItem(context: Context) : BaseItem(context){
        override fun onBindViewHolder(viewHolder: BaseViewHolder, position: Int) {

        }

        override fun getLayoutId(): Int {
            return R.layout.listitem_header
        }

    }

    @LegoRegister
    class FooterItem(context: Context) : BaseItem(context){
        override fun onBindViewHolder(viewHolder: BaseViewHolder, position: Int) {

        }

        override fun getLayoutId(): Int {
            return R.layout.listitem_footer
        }

    }
}
