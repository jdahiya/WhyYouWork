package com.example.j.bluetooth;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Michelle on 3/12/2016.
 */
public class AddWearableDialogFragment extends DialogFragment {

    private DialogInterface.OnClickListener onClickListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.wearables);

        View view = getActivity().getLayoutInflater().inflate(R.layout.add_wearable, null);

        Spinner dropdown = (Spinner) view.findViewById(R.id.add_wearable_spinner);
        String[] items = new String[] {
                "Buttocks",
                "Tail bone",
                "Shoulder blade",
                "Heel",
                "Outer ankle"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        float dpi = getResources().getDisplayMetrics().density;
        builder.setView(view, (int) (25 *dpi), (int)(10*dpi), (int)(14*dpi), (int) (5 * dpi));

        builder.setPositiveButton(R.string.add_wearable, onClickListener);

        builder.setNegativeButton(R.string.cancel_wearable, null);

        return builder.create();
    }

    public void setOnAddClickListener(DialogInterface.OnClickListener listener) {
        this.onClickListener = listener;
    }
}
