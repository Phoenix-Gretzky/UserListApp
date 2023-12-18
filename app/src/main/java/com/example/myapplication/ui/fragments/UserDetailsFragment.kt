package com.example.myapplication.ui.fragments

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.transition.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.myapplication.R
import com.example.myapplication.data.model.User
import com.example.myapplication.databinding.FragmentUserDetailsBinding

/**
 * A simple [Fragment] subclass.
 * Use the [UserDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserDetailsFragment : Fragment() {

    lateinit var binding: FragmentUserDetailsBinding
    val args: UserDetailsFragmentArgs by navArgs()
    lateinit var user: User;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        user = args.userData!!;
        setViewProperties()

        return binding.root
    }


    private fun setViewProperties() {
        try {
            binding.heading.text = "User Details"
            LoadCircleImageIntoImageView(requireContext(), user, binding.image)
            setBasicInfo()
            setTechInfo()
            setAddressInfo()
            setBankInfo()
            setOfficialInfo()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun setBasicInfo() {

        try {
            binding.BasicInfo.subheading.text = "Personal Details"
            binding.name.text = user.firstName + " " + user.lastName
            binding.BasicInfo.key1.text = "First Name"
            binding.BasicInfo.key2.text = "Last Name"
            binding.BasicInfo.key3.text = "Maiden Name"
            binding.BasicInfo.key4.text = "Age"
            binding.BasicInfo.key5.text = "Gender"
            binding.BasicInfo.key6.text = "Email"
            binding.BasicInfo.key7.text = "Phone"
            binding.BasicInfo.key8.text = "Hair Color"
            binding.BasicInfo.key9.text = "hair Type"
            binding.BasicInfo.key10.text = "Birth Date"
            binding.BasicInfo.key11.text = "Blood Group"
            binding.BasicInfo.key12.text = "Height"
            binding.BasicInfo.key13.text = "Weight"
            binding.BasicInfo.key14.text = "Eye Color"
            binding.BasicInfo.key15.visibility = View.GONE


            binding.BasicInfo.value1.text = user.firstName
            binding.BasicInfo.value2.text = user.lastName
            binding.BasicInfo.value3.text = user.maidenName
            binding.BasicInfo.value4.text = user.age.toString()
            binding.BasicInfo.value5.text = user.gender
            binding.BasicInfo.value6.text = user.email
            binding.BasicInfo.value7.text = user.phone
            binding.BasicInfo.value8.text = user.hair.color
            binding.BasicInfo.value9.text = user.hair.type
            binding.BasicInfo.value10.text = user.birthDate
            binding.BasicInfo.value11.text = user.bloodGroup
            binding.BasicInfo.value12.text = user.height.toString()
            binding.BasicInfo.value13.text = user.weight.toString()
            binding.BasicInfo.value14.text = user.eyeColor
            binding.BasicInfo.value15.visibility = View.GONE
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun setTechInfo() {

        try {
            binding.techInfo.subheading.text = "Technical Details"
            binding.techInfo.key1.text = "Domain"
            binding.techInfo.key2.text = "IP"
            binding.techInfo.key3.text = "MAC Address"
            binding.techInfo.key4.text = "Username"
            binding.techInfo.key5.text = "Password"
            binding.techInfo.key6.visibility = View.GONE
            binding.techInfo.key7.visibility = View.GONE
            binding.techInfo.key8.visibility = View.GONE
            binding.techInfo.key9.visibility = View.GONE
            binding.techInfo.key10.visibility = View.GONE
            binding.techInfo.key11.visibility = View.GONE
            binding.techInfo.key12.visibility = View.GONE
            binding.techInfo.key13.visibility = View.GONE
            binding.techInfo.key14.visibility = View.GONE
            binding.techInfo.key15.visibility = View.GONE



            binding.techInfo.value1.text = user.domain
            binding.techInfo.value2.text = user.ip
            binding.techInfo.value3.text = user.macAddress
            binding.techInfo.value4.text = user.username
            binding.techInfo.value5.text = user.password
            binding.techInfo.value6.visibility = View.GONE
            binding.techInfo.value7.visibility = View.GONE
            binding.techInfo.value8.visibility = View.GONE
            binding.techInfo.value9.visibility = View.GONE
            binding.techInfo.value10.visibility = View.GONE
            binding.techInfo.value11.visibility = View.GONE
            binding.techInfo.value12.visibility = View.GONE
            binding.techInfo.value13.visibility = View.GONE
            binding.techInfo.value14.visibility = View.GONE
            binding.techInfo.value15.visibility = View.GONE
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun setAddressInfo() {

        try {
            binding.addressInfo.subheading.text = "Address Details"

            binding.addressInfo.key1.text = "Address"
            binding.addressInfo.key2.text = "City"
            binding.addressInfo.key3.text = "Latitude"
            binding.addressInfo.key4.text = "Longitude"
            binding.addressInfo.key5.text = "Postal Code"
            binding.addressInfo.key6.text = "State"
            binding.addressInfo.key7.text = "University"
            binding.addressInfo.key8.visibility = View.GONE
            binding.addressInfo.key9.visibility = View.GONE
            binding.addressInfo.key10.visibility = View.GONE
            binding.addressInfo.key11.visibility = View.GONE
            binding.addressInfo.key12.visibility = View.GONE
            binding.addressInfo.key13.visibility = View.GONE
            binding.addressInfo.key14.visibility = View.GONE
            binding.addressInfo.key15.visibility = View.GONE


            binding.addressInfo.value1.text = user.address.address
            binding.addressInfo.value2.text = user.address.city
            binding.addressInfo.value3.text = user.address.coordinates.lat.toString()
            binding.addressInfo.value4.text = user.address.coordinates.lng.toString()
            binding.addressInfo.value5.text = user.address.postalCode
            binding.addressInfo.value6.text = user.address.state
            binding.addressInfo.value7.text = user.university
            binding.addressInfo.value8.visibility = View.GONE
            binding.addressInfo.value9.visibility = View.GONE
            binding.addressInfo.value10.visibility = View.GONE
            binding.addressInfo.value11.visibility = View.GONE
            binding.addressInfo.value12.visibility = View.GONE
            binding.addressInfo.value13.visibility = View.GONE
            binding.addressInfo.value14.visibility = View.GONE
            binding.addressInfo.value15.visibility = View.GONE
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun setBankInfo() {

        try {
            binding.bankInfo.subheading.text = "Bank Details"

            binding.bankInfo.key1.text = "Card Type"
            binding.bankInfo.key2.text = "Card Number"
            binding.bankInfo.key3.text = "Currency"
            binding.bankInfo.key4.text = "Iban"
            binding.bankInfo.key5.text = "Card Expire"
            binding.bankInfo.key6.visibility = View.GONE
            binding.bankInfo.key7.visibility = View.GONE
            binding.bankInfo.key8.visibility = View.GONE
            binding.bankInfo.key9.visibility = View.GONE
            binding.bankInfo.key10.visibility = View.GONE
            binding.bankInfo.key11.visibility = View.GONE
            binding.bankInfo.key12.visibility = View.GONE
            binding.bankInfo.key13.visibility = View.GONE
            binding.bankInfo.key14.visibility = View.GONE
            binding.bankInfo.key15.visibility = View.GONE


            binding.bankInfo.value1.text = user.bank.cardType
            binding.bankInfo.value2.text = user.bank.cardNumber
            binding.bankInfo.value3.text = user.bank.currency
            binding.bankInfo.value4.text = user.bank.iban
            binding.bankInfo.value5.text = user.bank.cardExpire
            binding.bankInfo.value6.visibility = View.GONE
            binding.bankInfo.value7.visibility = View.GONE
            binding.bankInfo.value8.visibility = View.GONE
            binding.bankInfo.value9.visibility = View.GONE
            binding.bankInfo.value10.visibility = View.GONE
            binding.bankInfo.value11.visibility = View.GONE
            binding.bankInfo.value12.visibility = View.GONE
            binding.bankInfo.value13.visibility = View.GONE
            binding.bankInfo.value14.visibility = View.GONE
            binding.bankInfo.value15.visibility = View.GONE
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun setOfficialInfo() {

        try {
            binding.officialInfo.subheading.text = "Official Details"

            binding.officialInfo.key1.text = "Department"
            binding.officialInfo.key2.text = "Name"
            binding.officialInfo.key3.text = "Title"
            binding.officialInfo.key4.text = "Address"
            binding.officialInfo.key5.text = "City"
            binding.officialInfo.key6.text = "Latitude"
            binding.officialInfo.key7.text = "Longitude"
            binding.officialInfo.key8.text = "Postal Code"
            binding.officialInfo.key9.visibility = View.GONE
            binding.officialInfo.key10.visibility = View.GONE
            binding.officialInfo.key11.visibility = View.GONE
            binding.officialInfo.key12.visibility = View.GONE
            binding.officialInfo.key13.visibility = View.GONE
            binding.officialInfo.key14.visibility = View.GONE
            binding.officialInfo.key15.visibility = View.GONE


            binding.officialInfo.value1.text = user.company.department
            binding.officialInfo.value2.text = user.company.name
            binding.officialInfo.value3.text = user.company.title
            binding.officialInfo.value4.text = user.company.address.address
            binding.officialInfo.value5.text = user.company.address.city
            binding.officialInfo.value6.text = user.company.address.coordinates.lat.toString()
            binding.officialInfo.value7.text = user.company.address.coordinates.lng.toString()
            binding.officialInfo.value8.text = user.company.address.postalCode
            binding.officialInfo.value9.visibility = View.GONE
            binding.officialInfo.value10.visibility = View.GONE
            binding.officialInfo.value11.visibility = View.GONE
            binding.officialInfo.value12.visibility = View.GONE
            binding.officialInfo.value13.visibility = View.GONE
            binding.officialInfo.value14.visibility = View.GONE
            binding.officialInfo.value15.visibility = View.GONE
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * This function will load the image into imageview using glide library and also transform the image to circle using the CircleTranform method
     *
     * @param mContext  -- Context of activity
     * @param resId     -- Int ( Image Resource Id)
     * @param imageView -- Imageview to which image is to be loaded
     */
    fun LoadCircleImageIntoImageView(mContext: Context, user: User, imageView: ImageView) {
        try {
            // set shape of the image and divider line
            // set oval shape of the image stroke border
            val gradientDrawable = GradientDrawable()
            // SHape == 1 means Oval Shape
            gradientDrawable.shape = GradientDrawable.OVAL
            gradientDrawable.setStroke(2, Color.parseColor("#737373"))
            imageView.setBackground(gradientDrawable)
            (mContext as Activity).runOnUiThread {
                // using glide library to set image into image view
                Glide.with(mContext)
                    .load(user.image)
                    .circleCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(
                        imageView
                    )
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

}
























