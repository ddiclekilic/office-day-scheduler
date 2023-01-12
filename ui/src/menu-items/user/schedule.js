// assets
import CalendarMonthIcon from '@mui/icons-material/CalendarMonth';
// constant
const icons = { CalendarMonthIcon };

// ==============================|| SCHEDULE MENU ITEMS ||============================== //

const schedule = {
    id: 'schedule-group',
    type: 'group',
    children: [
        {
            id: 'schedule',
            title: 'My Schedule',
            type: 'item',
            url: '/user/schedule',
            icon: icons.CalendarMonthIcon,
            breadcrumbs: false
        }
    ]
};

export default schedule;
