package br.com.victor.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import br.com.victor.customviews.databinding.CustomElementBinding

class CustomElement(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private var title: String?
    private var subtitle: String?
    private var description: String?
    private var numberOfButtons: Int
    private var buttonOneTitle: String?
    private var buttonTwoTitle: String?
    private var binding: CustomElementBinding =
        CustomElementBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomElement,
            0, 0
        ).apply {
            try {
                title = getString(R.styleable.CustomElement_title)
                subtitle = getString(R.styleable.CustomElement_subtitle)
                description = getString(R.styleable.CustomElement_description)
                numberOfButtons = getInteger(R.styleable.CustomElement_numberOfButtons, 0)
                buttonOneTitle = getString(R.styleable.CustomElement_buttonOneTitle)
                buttonTwoTitle = getString(R.styleable.CustomElement_buttonTwoTitle)
            } finally {
                recycle()
            }

            setInformation()
        }
    }

    private fun setInformation() {
        defineTitle()
        defineSubtitle()
        defineDescription()
        defineNumberOfButtons()
        defineButtonOneTitle()
        defineButtonTwoTitle()
    }

    private fun defineTitle() {
        title?.let {
            binding.tvTitle.text = title
            binding.tvTitle.visible()
        }
    }

    private fun defineSubtitle() {
        subtitle?.let {
            binding.tvSubtitle.text = subtitle
            binding.tvSubtitle.visible()
        }
    }

    private fun defineDescription() {
        description?.let {
            binding.tvDescription.text = description
            binding.tvDescription.visible()
        }
    }

    private fun defineNumberOfButtons() {
        when (numberOfButtons) {
            0 -> binding.llButtons.gone()
            1 -> binding.buttonTwo.gone()
            2 -> {}
        }
    }

    private fun defineButtonOneTitle() {
        buttonOneTitle?.let { binding.buttonOne.text = buttonOneTitle }
    }

    private fun defineButtonTwoTitle() {
        buttonTwoTitle?.let { binding.buttonTwo.text = buttonTwoTitle }
    }

    fun setTitle(newTitle: String) {
        binding.tvTitle.text = newTitle
        invalidate()
        requestLayout()
    }

    fun setSubtitle(newSubtitle: String) {
        binding.tvSubtitle.text = newSubtitle
        invalidate()
        requestLayout()
    }

    fun setDescription(newDescription: String) {
        binding.tvDescription.text = newDescription
        invalidate()
        requestLayout()
    }

    fun setNumberOfButtons(number: Int) {
        when (number) {
            0 -> binding.llButtons.gone()
            1 -> binding.buttonTwo.gone()
            2 -> {}
        }
        invalidate()
        requestLayout()
    }

    fun setButtonOneText(newText: String) {
        binding.buttonOne.text = newText
        invalidate()
        requestLayout()
    }

    fun setButtonTwoText(newText: String) {
        binding.buttonTwo.text = newText
        invalidate()
        requestLayout()
    }

}