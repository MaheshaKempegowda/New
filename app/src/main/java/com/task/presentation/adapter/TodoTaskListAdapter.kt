package com.task.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.core.domain.model.TodoTaskList
import com.task.databinding.TodoTaskItemBinding

class TodoTaskListAdapter(
    private val context: Context,
    private val todoTaskList: ArrayList<TodoTaskList>,
) : RecyclerView.Adapter<TodoTaskListAdapter.TodoTaskViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateTodoTaskList(newTodoTaskList: ArrayList<TodoTaskList>) {
        todoTaskList.clear()
        todoTaskList.addAll(newTodoTaskList)
        notifyDataSetChanged()
    }

    inner class TodoTaskViewHolder(private val binding: TodoTaskItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            data: TodoTaskList,
            context: Context,
            channelList: ArrayList<TodoTaskList>,
        ) {
            binding.tvtask.text = data.title
            if (data.status == true) {
                binding.tvstatus.text = "Compleated"
            } else {
                binding.tvstatus.text = "Pending"
            }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoTaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TodoTaskItemBinding.inflate(inflater, parent, false)
        return TodoTaskViewHolder(binding)
    }

    override fun getItemCount() = todoTaskList.size

    override fun onBindViewHolder(holder: TodoTaskViewHolder, position: Int) {
        val data = todoTaskList[position]
        holder.bind(data, context, todoTaskList)
    }


}