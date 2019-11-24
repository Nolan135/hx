package hx.edu.huatec.com.hx.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;

import hx.edu.huatec.com.hx.R;
import hx.edu.huatec.com.hx.comm.BaseFragment;

public class NavigationFragment extends BaseFragment implements View.OnClickListener {


    private ImageButton mIbHome, mIbCategory, mIbCart, mIbPersonal;
    private HomeFragment homeFragment;
    private CategroyFragment categoryFragment;
    private CartFragment cartFragment;
    private PersonalFragment personFragment;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_navigation;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        // 初始化控件
        mIbHome = view.findViewById(R.id.ib_home);
        mIbCategory = view.findViewById(R.id.ib_category);
        mIbCart = view.findViewById(R.id.ib_cart);
        mIbPersonal = view.findViewById(R.id.ib_personal);
        // 设置监听器，监听点击事件
        mIbHome.setOnClickListener(this);
        mIbCategory.setOnClickListener(this);
        mIbCart.setOnClickListener(this);
        mIbPersonal.setOnClickListener(this);

        // 设置页面初始化选择
        select(mIbHome);
    }

    private void select(View view) {
        // 重置UI，将按钮图标全部恢复为未选中状态，在下面判断具体的点击位置，并设置它的选中状态
        mIbHome.setImageResource(R.drawable.tab_item_home_normal);
        mIbCategory.setImageResource(R.drawable.tab_item_category_normal);
        mIbCart.setImageResource(R.drawable.tab_item_cart_normal);
        mIbPersonal.setImageResource(R.drawable.tab_item_personal_normal);
        // Fragment管理类初始化
        FragmentManager fragmentManager = getFragmentManager();
        // 防止Fragment管理类报null
        assert fragmentManager != null;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // 判断Fragment 是否为null，隐藏fragment，判断点击展示Fragment
        if (homeFragment != null) {
            // hide是隐藏方法
            fragmentTransaction.hide(homeFragment);
        }
        if (categoryFragment != null) {
            // hide是隐藏方法
            fragmentTransaction.hide(categoryFragment);
        }
        if (cartFragment != null) {
            // hide是隐藏方法
            fragmentTransaction.hide(cartFragment);
        }
        if (personFragment != null) {
            // hide是隐藏方法
            fragmentTransaction.hide(personFragment);
        }
        // 使用switch循环判断用户的点击
        switch (view.getId()) {
            case R.id.ib_home:
                // 更换选中的图标
                mIbHome.setImageResource(R.drawable.tab_item_home_focus);
                // 判断为null的情况
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    // 在Fragment管理事务中添加当前选中的Fragment
                    fragmentTransaction.add(R.id.fl_main_navigation, homeFragment);
                } else {
                    // 不为空的情况直接显示fragment
                    fragmentTransaction.show(homeFragment);
                }
                break;
            case R.id.ib_category:
                // 更换选中的图标
                mIbCategory.setImageResource(R.drawable.tab_item_category_focus);
                // 判断为null的情况
                if (categoryFragment == null) {
                    categoryFragment = new CategroyFragment();
                    // 在Fragment管理事务中添加当前选中的Fragment
                    fragmentTransaction.add(R.id.fl_main_navigation, categoryFragment);
                } else {
                    // 不为空的情况直接显示fragment
                    fragmentTransaction.show(categoryFragment);
                }
                break;
            case R.id.ib_cart:
                // 更换选中的图标
                mIbCart.setImageResource(R.drawable.tab_item_cart_focus);
                // 判断为null的情况
                if (cartFragment == null) {
                    cartFragment = new CartFragment();
                    // 在Fragment管理事务中添加当前选中的Fragment
                    fragmentTransaction.add(R.id.fl_main_navigation, cartFragment);
                } else {
                    // 不为空的情况直接显示fragment
                    fragmentTransaction.show(cartFragment);
                }
                break;
            case R.id.ib_personal:
                // 更换选中的图标
                mIbPersonal.setImageResource(R.drawable.tab_item_personal_focus);
                // 判断为null的情况
                if (personFragment == null) {
                    personFragment = new PersonalFragment();
                    // 在Fragment管理事务中添加当前选中的Fragment
                    fragmentTransaction.add(R.id.fl_main_navigation, personFragment);
                } else {
                    // 不为空的情况直接显示fragment
                    fragmentTransaction.show(personFragment);
                }
                break;
            default:
                // 其他情况，根据阿里规约都是要写，养成良好的代码习惯
                break;
        }
        // fragment管理事务提交，必须写，要不然应用会出现切换崩溃的情况
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        // 每次点击事件执行按钮选择方法
        select(v);
    }
}
