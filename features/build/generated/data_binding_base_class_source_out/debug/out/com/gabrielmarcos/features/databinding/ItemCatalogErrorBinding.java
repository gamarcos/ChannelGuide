// Generated by view binder compiler. Do not edit!
package com.gabrielmarcos.features.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.gabrielmarcos.features.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class ItemCatalogErrorBinding implements ViewBinding {
  @NonNull
  private final LinearLayoutCompat rootView;

  @NonNull
  public final LinearLayoutCompat errorContent;

  private ItemCatalogErrorBinding(@NonNull LinearLayoutCompat rootView,
      @NonNull LinearLayoutCompat errorContent) {
    this.rootView = rootView;
    this.errorContent = errorContent;
  }

  @Override
  @NonNull
  public LinearLayoutCompat getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemCatalogErrorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemCatalogErrorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_catalog_error, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemCatalogErrorBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    LinearLayoutCompat errorContent = (LinearLayoutCompat) rootView;

    return new ItemCatalogErrorBinding((LinearLayoutCompat) rootView, errorContent);
  }
}
