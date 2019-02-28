package com.kalelman.recyclerviewcardviewretrofit.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kalelman.recyclerviewcardviewretrofit.R;
import com.kalelman.recyclerviewcardviewretrofit.model.Employee;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder> {

    private ArrayList<Employee> dataList;

    public EmployeeAdapter(ArrayList<Employee> dataList) {
        this.dataList = dataList;
    }

    public static class EmployeeHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_employee_name)
        TextView txvEmployeeName;
        @BindView(R.id.txt_employee_email)
        TextView txvEmployeeEmail;
        @BindView(R.id.txt_employee_phone)
        TextView txvEmployeePhone;

        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

    @NonNull
    @Override
    public EmployeeAdapter.EmployeeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);

        return new EmployeeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.EmployeeHolder employeeHolder, int position) {
        employeeHolder.txvEmployeeName.setText(dataList.get(position).getName());
        employeeHolder.txvEmployeeEmail.setText(dataList.get(position).getEmail());
        employeeHolder.txvEmployeePhone.setText(dataList.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
