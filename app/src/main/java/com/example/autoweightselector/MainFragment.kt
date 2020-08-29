package com.example.autoweightselector

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.autoweightselector.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //myViewModel 綁定
        val myViewModel = activity?.run {
            ViewModelProvider(this).get(MyViewModel::class.java) } ?:throw Exception ("Invalid Activity")
        //Databinding 綁定
      //  val databinding1 =
        val dataBinding = FragmentMainBinding.inflate(inflater,container,false)

        dataBinding.setData(myViewModel)
        dataBinding.setLifecycleOwner(this)
        return dataBinding.root
        // Inflate the layout for this fragment
     //   return inflater.inflate(R.layout.fragment_main, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //myViewModel 綁定
        val myViewModel = activity?.run {
            ViewModelProvider(this).get(MyViewModel::class.java) } ?:throw Exception ("Invalid Activity")

        //內容寫在此

        //底下是測試碼
        btnExit.setOnClickListener {
            findNavController().navigate(R.id.opFragment)  //跳到另一個Fragment
        }
    }
}