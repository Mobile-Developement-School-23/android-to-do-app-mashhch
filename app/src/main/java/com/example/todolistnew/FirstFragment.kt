package com.example.todolistnew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.data.TodoItem
import com.example.todolist.data.TodoItemsRepository
import com.example.todolistnew.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    lateinit var  itemsRecycleView: RecyclerView
    private val itemsPreviewReporository = TodoItemsRepository()
    private var Item_adapter : ItemsAdapter = ItemsAdapter()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)


        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

       //DEAD
        itemsRecycleView.adapter = Item_adapter
        itemsRecycleView.layoutManager= layoutManager
        itemsRecycleView.setHasFixedSize(true)

        Item_adapter.setList(itemsPreviewReporository.getItems())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    private fun dataInitialize(){
//        itemsArrayList = arrayListOf<TodoItem>()
//
//        titles = arrayListOf("lalala", "yandexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
//        ids = arrayListOf<Int>(0,1)
//
//        for ( i in ids.indices){
//            val item_ = TodoItem(ids[i], titles[i])
//            itemsArrayList.add(item_)
//
//        }
//    }
}