package pl.k2net.boilerandroid.item.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import pl.k2net.boilerandroid.R;
import pl.k2net.boilerandroid.common.ui.BaseFragment;
import pl.k2net.boilerandroid.domain.model.ItemModel;
import pl.k2net.boilerandroid.presentation.presenter.ItemPresenter;
import timber.log.Timber;

public class ItemFragment extends BaseFragment implements ItemPresenter.ViewInterface {

    @Inject
    ItemPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        fragmentInjector().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.bind(this);
        presenter.getItemList();
    }

    @Override
    public void showItemList(List<ItemModel> itemModelList) {
        Timber.d(itemModelList.toString());
    }
}
