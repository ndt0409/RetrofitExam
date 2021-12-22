package com.ndt.quanretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ndt.quanretrofit.adapter.ExamAdapter
import com.ndt.quanretrofit.databinding.ActivityMainBinding
import com.ndt.quanretrofit.model.ArticlesModel
import com.ndt.quanretrofit.model.Exam
import com.ndt.quanretrofit.network.ExamClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ExamAdapter
    private var listExam = arrayListOf<ArticlesModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ExamAdapter(listExam)
        binding.rvExam.adapter = adapter
        binding.rvExam.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        getAllExam()


    }

    fun getAllExam() {
        lifecycleScope.launch(Dispatchers.IO) {
            var response: Response<Exam> = ExamClient().getAllExam().execute()
            if (response.isSuccessful) {
                response.body()?.let {
                    binding.tvStatussss.text = it.status
                    binding.tvTotalResultssss.text = it.totalResults
                    listExam.addAll(it.articles)
                }
                withContext(Dispatchers.Main) {
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}