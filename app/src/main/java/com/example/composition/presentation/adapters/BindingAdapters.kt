package com.example.composition.presentation.adapters

import android.content.Context
import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.composition.R
import com.example.composition.domain.entity.GameResults

interface OnOptionClickListener {

    fun optionClick(option: Int)
}

@BindingAdapter("requiredAnswers")
fun bindRequiredAnswers(textView: TextView, value: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_score), value
    )
}

@BindingAdapter("scoreAnswers")
fun bindScoreAnswers(textView: TextView, value: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.score_answers), value
    )
}

@BindingAdapter("requiredPercentage")
fun bindRequiredPercentage(textView: TextView, value: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_percentage), value
    )
}

@BindingAdapter("scorePercentage")
fun bindScorePercentage(textView: TextView, gameResult: GameResults) {
    val value = if (gameResult.countOfQuestions == 0) {
        0
    } else {
        ((gameResult.countOfRightAnswers / gameResult.countOfQuestions.toDouble()) * 100).toInt()
    }
    textView.text = String.format(
        textView.context.getString(R.string.required_percentage), value
    )
}

@BindingAdapter("emojiResult")
fun bindEmojiResult(imageView: ImageView, winOrNot: Boolean) {
    val getSmileResId: Int =
        if (winOrNot) {
            R.drawable.ic_smile
        } else {
            R.drawable.ic_sad
        }
    imageView.setImageResource(getSmileResId)
}

@BindingAdapter("enoughCountOfRightAnswers")
fun bindCountOfRightAnswers(textView: TextView, enough: Boolean) {
    textView.setTextColor(getColorByState(textView.context, enough))
}

@BindingAdapter("enoughPercentOfRightAnswers")
fun bindPercentOfRightAnswers(progressBar: ProgressBar, enough: Boolean) {
    val color = getColorByState(progressBar.context, enough)
    progressBar.progressTintList = ColorStateList.valueOf(color)
}

private fun getColorByState(context: Context, goodState: Boolean): Int {
    val colorResId = if (goodState) {
        android.R.color.holo_green_light
    } else {
        android.R.color.holo_red_light
    }
    return ContextCompat.getColor(context, colorResId)
}

@BindingAdapter("fromIntToString")
fun bindFromIntToString(textView: TextView, number: Int) {
    textView.text = number.toString()
}

@BindingAdapter("onOptionClickListener")
fun bindOptionCLick(textView: TextView, clickListener: OnOptionClickListener) {
    textView.setOnClickListener {
        clickListener.optionClick(textView.text.toString().toInt())
    }
}
