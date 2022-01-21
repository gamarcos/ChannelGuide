package com.gabrielmarcos.features.catalog.presentation

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.DefaultItemAnimator
import com.bumptech.glide.Glide
import com.gabrielmarcos.features.R
import com.gabrielmarcos.features.catalog.presentation.adapter.CatalogChannelAdapter
import com.gabrielmarcos.features.catalog.presentation.adapter.LoadState
import com.gabrielmarcos.features.catalog.presentation.adapter.LoadStateAdapter
import org.koin.android.ext.android.inject

class CatalogChannelActivity : AppCompatActivity() {

    private val viewModel: CatalogChannelViewModel by inject()

    private val catalogRecyclerView by lazy { findViewById<RecyclerView>(R.id.catalog_list) }
    private val errorView by lazy { findViewById<LinearLayoutCompat>(R.id.error_content) }
    private val progressView by lazy { findViewById<ProgressBar>(R.id.catalog_loading) }

    private lateinit var catalogChannelAdapter: CatalogChannelAdapter
    private lateinit var loadStateAdapter: LoadStateAdapter

    private val onScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                loadStateAdapter.loadState = LoadState.Loading
                getChannels()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)

        loadStateAdapter = LoadStateAdapter()
        catalogChannelAdapter = CatalogChannelAdapter()

        getChannels()

        catalogRecyclerView.apply {
            adapter = ConcatAdapter(
                catalogChannelAdapter,
                loadStateAdapter
            )
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
            addOnScrollListener(onScrollListener)
        }

        errorView.setOnClickListener {
            progressView.visibility = View.VISIBLE
            errorView.visibility = View.GONE
            getChannels()
        }

        setupObservables()
    }

    private fun setupObservables() {
        viewModel.channels.observe(this, { catalog ->
            progressView.visibility = View.GONE
            errorView.visibility = View.GONE
            catalogChannelAdapter.items = catalog.toMutableList()
        })

        viewModel.onError.observe(this, {
            errorView.visibility = View.VISIBLE
            progressView.visibility = View.GONE
        })
    }

    private fun getChannels() {
        viewModel.getChannels()
    }
}