package com.kakudi.category.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kakudi.R
import com.kakudi.category.data.model.Category
import com.kakudi.shared.ext.hide

/**
 *@author meshileya seun <mesh@kudi.ai/>
 *@date 20/04/2019
 */
class CategoryAdapter(val context: Context) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewholder>() {

    var categoryList: List<Category> = emptyList()

    fun setCategoryListData(list: List<Category>) {
        categoryList = categoryList.plus(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewholder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.category_list_content, parent, false)
        return CategoryViewholder(view)
    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: CategoryViewholder, position: Int) {
        holder.bindCategory(categoryList[position])
    }

    abstract class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bindCategory(category: Category)
    }

    inner class CategoryViewholder(itemView: View) : ViewHolder(itemView) {

        private val categoryTextView: TextView = itemView.findViewById(R.id.categoryNameTextView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)

        override fun bindCategory(category: Category) {
            categoryTextView.text = category.name.toLowerCase().capitalize()
            descriptionTextView.text = category.description

            if(category.description.isNullOrEmpty()) {
                descriptionTextView.hide()
            }
        }
    }
}