import { lazy } from 'react';

// project imports
import Loadable from 'ui-component/Loadable';
import AdminLayout from 'layout/AdminLayout';
import UserLayout from 'layout/UserLayout';
// login option 3 routing
// dashboard routing
const RolePage = Loadable(lazy(() => import('views/admin/role')));
const DepartmentPage = Loadable(lazy(() => import('views/admin/department')));
const OutOfOfficeDayPage = Loadable(lazy(() => import('views/admin/out-of-office-day')));
const UserPage = Loadable(lazy(() => import('views/admin/userList')));
const ZonePage = Loadable(lazy(() => import('views/admin/zone')));
const SchedulePage = Loadable(lazy(() => import('views/admin/schedule')));
const CalendarPage = Loadable(lazy(() => import('views/admin/calendar')));
// ==============================|| AUTHENTICATION ROUTING ||============================== //

const AuthenticationRoutes = {
    path: '/',
    element: <AdminLayout />,
    children: [
        {
            path: '/admin/role',
            element: <RolePage />
        },
        {
            path: '/admin/department',
            element: <DepartmentPage />
        },
        {
            path: '/admin/out-of-office-day',
            element: <OutOfOfficeDayPage />
        },
        {
            path: '/admin/user-list',
            element: <UserPage />
        },
        {
            path: '/admin/zone',
            element: <ZonePage />
        },
        {
            path: '/admin/schedule',
            element: <SchedulePage />
        },
        {
            path: '/admin/calendar',
            element: <CalendarPage />
        }
    ]
};

export default AuthenticationRoutes;
