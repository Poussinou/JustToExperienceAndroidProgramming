package foss.poussinou.textview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

//tuto 8, listview adapter, lié à adapter_view_layout

public class PersonListAdapter extends ArrayAdapter<Person>{

    private static final String TAG = "PersonListAdapter";

    private Context monContext;
    private int maRessource;
    private int lastPosition = -1;

    static class ViewHolder {
        TextView name;
        TextView birthday;
        TextView sex;
    }

    public PersonListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Person> objects) {
        super(context, resource, objects);
        monContext = context;
        maRessource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        String birthday = getItem(position).getBirthday();
        String sex = getItem(position).getSex();

        //Create the person object with the information
        Person person = new Person(name,birthday,sex);

        //create the view result for showing the animation
        final View result;

        //Viewholder object
        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(monContext);
            convertView = inflater.inflate(maRessource, parent, false);

            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.textView1AdapterView);
            holder.birthday = (TextView) convertView.findViewById(R.id.textView2AdapterView);
            holder.sex = (TextView) convertView.findViewById(R.id.textView3AdapterView);

            result = convertView;

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        //Utile que dans le tuto 8 et pas le 9
        //TextView affichageNom = (TextView) convertView.findViewById(R.id.textView1AdapterView);
        //TextView affichageBirthday = (TextView) convertView.findViewById(R.id.textView2AdapterView);
        //TextView affichageSex = (TextView) convertView.findViewById(R.id.textView3AdapterView);
        //affichageNom.setText(name);
        //affichageBirthday.setText(birthday);
        //affichageSex.setText(sex);

        Animation animation = AnimationUtils.loadAnimation(monContext,
                (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim); //(condition ? sivrai : sifaux)
        result.startAnimation(animation);
        lastPosition = position;

        holder.name.setText(person.getName());
        holder.birthday.setText(person.getBirthday());
        holder.sex.setText(person.getSex());

        return convertView;
    }
}
