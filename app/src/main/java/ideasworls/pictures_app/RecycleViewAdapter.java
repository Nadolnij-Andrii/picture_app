package ideasworls.pictures_app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;



public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{
    private List<PicturesList> pictures;
    public Context context ;
    View.OnClickListener onClickListener;
    public RecycleViewAdapter(Context Mcontext, List<PicturesList> pictures) {

        this.context = Mcontext;
        this.pictures = pictures;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final PicturesList picture = pictures.get(position);
        Uri uri = Uri.parse(picture.getImages().getNormal());
        holder.imageView.setImageURI(uri);

        holder.discription.setText(picture.getTitle());
        holder.title.setText(picture.getUpdatedAt());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                intent.putExtra("discr", picture.getDescription());
                intent.putExtra("title", picture.getTitle());
                intent.putExtra("date", picture.getUpdatedAt());
                intent.putExtra("image", picture.getImages().getNormal());
                v.getContext().startActivity(intent);
                //context.startActivity(intent);
            }
        });

    }

    @Override
        public int getItemCount() {
        if (pictures == null)
            return 0;
        return pictures.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView discription;
        TextView title;
        SimpleDraweeView imageView;


        public ViewHolder(View itemView) {
            super(itemView);

            discription = (TextView) itemView.findViewById(R.id.postitem_post);
            title = (TextView) itemView.findViewById(R.id.postitem_site);
            imageView = (SimpleDraweeView) itemView.findViewById(R.id.image);

        }


    }


}
