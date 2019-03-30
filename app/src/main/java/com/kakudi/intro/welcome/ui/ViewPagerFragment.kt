package com.kakudi.intro.welcome.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.kakudi.R
import com.kakudi.databinding.FragmentIntroPageBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class ViewPagerFragment : Fragment() {

    lateinit var binding: FragmentIntroPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_intro_page,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
    }

    private fun setView() {
        arguments.let {
            binding.descriptionTextView.text = it!!.getString(DESCRIPTION)
            binding.sliderView.setBackgroundResource(it.getInt(IMAGE_RESOURCE))

            binding.root.background = when (it.getInt(IMAGE_RESOURCE)) {
                R.drawable.slider_one ->

                    ContextCompat.getDrawable(activity!!.applicationContext, R.drawable.slider_one)

                R.drawable.slider_three ->

                    ContextCompat.getDrawable(activity!!.applicationContext, R.drawable.slider_three)

                else -> ContextCompat.getDrawable(
                    activity!!.applicationContext,
                    R.drawable.slider_two
                )
            }
        }
    }

    companion object {

        private const val IMAGE_RESOURCE = "IMAGE_RESOURCE"
        private const val DESCRIPTION = "DESCRIPTION"
        private const val BACKGROUND_COLOR = "BACKGROUND_COLOR"

        @JvmStatic
        fun instance(
            imageResource: Int,
            description: String,
            backgroundColor: Int
        ): ViewPagerFragment {
            return ViewPagerFragment().apply {
                arguments = Bundle().apply {
                    putInt(IMAGE_RESOURCE, imageResource)
                    putString(DESCRIPTION, description)
                    putInt(BACKGROUND_COLOR, backgroundColor)
                }
            }
        }
    }

}
