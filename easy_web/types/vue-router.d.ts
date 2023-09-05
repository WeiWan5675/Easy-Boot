export {};

declare module 'vue-router' {
  interface RouteMeta extends Record<string | number | symbol, unknown> {
    orderNo?: number;
    // 路由title
    title: string;
    // 动态路由可打开Tab页数
    dynamicLevel?: number;
    // 动态路由的实际Path, 即去除路由的动态部分
    realPath?: string;
    // 是否忽略权限，只在权限模式为Role的时候有效
    ignoreAuth?: boolean;
    // 可以访问的角色，只在权限模式为Role的时候有效
    roles?: RoleEnum[];
    // 是否忽略KeepAlive缓存
    ignoreKeepAlive?: boolean;
    // 是否固定标签
    affix?: boolean;
    // 图标，也是菜单图标
    icon?: string;
    // 内嵌iframe的地址
    frameSrc?: string;
    // 指定该路由切换的动画名
    transitionName?: string;
    // 隐藏该路由在面包屑上面的显示
    hideBreadcrumb?: boolean;
    // 隐藏所有子菜单
    hideChildrenInMenu?: boolean;
    // 如果该路由会携带参数，且需要在tab页上面显示。则需要设置为true
    carryParam?: boolean;
    // Used internally to mark single-level menus
    single?: boolean;
    // 当前激活的菜单。用于配置详情页时左侧激活的菜单路径
    currentActiveMenu?: string;
    // 当前路由不再标签页显示
    hideTab?: boolean;
    // 当前路由不再菜单显示
    hideMenu?: boolean;
    isLink?: boolean;
    // 忽略路由。用于在ROUTE_MAPPING以及BACK权限模式下，生成对应的菜单而忽略路由。2.5.3以上版本有效
    ignoreRoute?: boolean;
    // 是否在子级菜单的完整path中忽略本级path。2.5.3以上版本有效
    hidePathForChildren?: boolean;
  }
}
