package com.example.love.onBoarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.love.databinding.ItemVpBinding
import com.example.love.model.OnBoarding

class OnBoardingAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val list = arrayListOf(
        OnBoarding(
            "comfort.json",
            "Удобство",
            "приложения"
        ),
        OnBoarding(
            "time.json",
            "Экономия времени",
            "2 клика"
        ),
        OnBoarding(
            "safety.json",
            "Безопасность",
            "Безопасно"
        ),
        OnBoarding(
            "speed.json",
            "Скорость",
            "быстрая"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemVpBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemVpBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(onBoarding: OnBoarding) = with(binding) {
            tvTitle.text = onBoarding.title
            tvDesc.text = onBoarding.desc
            imgBoard.setAnimation(onBoarding.image)
            btnStart.setOnClickListener { onClick() }
            skip.setOnClickListener { onClick() }
            skip.isInvisible = adapterPosition == list.lastIndex
            btnStart.isVisible = adapterPosition == list.lastIndex
        }
    }
}