package com.xincubate.lego.sample

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.stars.kit.lego.adapter.core.BaseItem
import com.stars.kit.lego.adapter.core.BaseViewHolder
import com.stars.kit.lego.adapter.group.BaseGroupAdapter
import com.stars.kit.lego.adapter.group.BaseGroupItem
import com.xincubate.lego.annotation.LegoItem
import kotlinx.android.synthetic.main.activity_main.*

class GroupListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        title = "二级列表"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(RecycleViewDivider(this, LinearLayoutManager.VERTICAL))

        val baseAdapter = BaseGroupAdapter(this)

        for (i in 1..10){

            val children : ArrayList<BaseItem> = ArrayList()
            for (j in 1..5){
                children.add(ListActivity.SimpleListItem(this,i*100+j))
            }

            val group = SimpleGroupListItem(this,children,i)
            baseAdapter.addGroupItem(group)
        }

        recyclerView.adapter = baseAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item!!.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


    @LegoItem
    class SimpleGroupListItem(context: Context,children : List<BaseItem>,val id:Int) : BaseGroupItem(context,children) {

        override fun onBindViewHolder(viewHolder: BaseViewHolder, position: Int) {
            viewHolder.findViewById<TextView>(R.id.tv_title).text = "第${id}分组"
        }

        override fun getLayoutId(): Int {
            return R.layout.listitem_kind
        }

        override fun onClick() {

        }
    }
}
