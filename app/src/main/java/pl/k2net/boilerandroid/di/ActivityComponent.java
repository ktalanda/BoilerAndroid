package pl.k2net.boilerandroid.di;

import dagger.Component;
import pl.k2net.boilerandroid.common.ui.BaseActivity;
import pl.k2net.boilerandroid.di.module.ViewModule;
import pl.k2net.boilerandroid.di.scope.PerActivity;

@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = { ViewModule.class }
)
public interface ActivityComponent extends ActivityInjector, FragmentInjector {
    final class Initializer {
        private Initializer() { }
        public static ActivityComponent init(ApplicationComponent component, BaseActivity baseActivity) {
            return DaggerActivityComponent
                    .builder()
                    .applicationComponent(component)
                    .viewModule(new ViewModule(baseActivity))
                    .build();
        }
    }
}
