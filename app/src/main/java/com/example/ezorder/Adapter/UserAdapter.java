package com.example.ezorder.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ezorder.Model.User;
import com.example.ezorder.R;

import java.util.List;

public class UserAdapter extends BaseAdapter {

    Context context;
    int resource;
    List<User> objects;
    ViewHolderUser holderUser;

    public UserAdapter(Context context, int resource, List<User> objects) {
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int i) {
        return objects.get(i);
    }

    @Override
    public long getItemId(int i) {
        return objects.get(i).getUserID();
    }

    public class ViewHolderUser {
        TextView usName, usRole;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        if (view == null) {
            holderUser = new ViewHolderUser();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(resource, viewGroup, false);

            holderUser.usName = (TextView) view.findViewById(R.id.txtName);
            holderUser.usRole = (TextView) view.findViewById(R.id.txtStatus);

            view.setTag(holderUser);
        } else {
            holderUser = (ViewHolderUser) view.getTag();
        }

        User dto = objects.get(i);

        holderUser.usName.setText(dto.getUserName());
        holderUser.usRole.setText(String.valueOf(dto.getUser_role()));

        return view;
    }
}
