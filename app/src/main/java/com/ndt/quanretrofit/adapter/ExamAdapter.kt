package com.ndt.quanretrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ndt.quanretrofit.databinding.ItemArticlesBinding
import com.ndt.quanretrofit.model.ArticlesModel
class ExamAdapter(private var articlesmoelList: List<ArticlesModel>) :
    RecyclerView.Adapter<ExamAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemArticlesBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(articlesmoelList[position])
    }

    override fun getItemCount(): Int = articlesmoelList.size
    class ViewHolder(private var binding: ItemArticlesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(it: ArticlesModel) {
            binding.tvAuthorArticles.text = it.author
            binding.tvContentArticles.text = it.content
            binding.tvDescriptionArticles.text = it.description
            binding.tvPublishedAtArticles.text = it.publishedAt
            binding.tvTitleArticles.text = it.title

            binding.tvIDSource.text = it.source.id
            binding.tvNameSource.text = it.source.name
        }
    }
}