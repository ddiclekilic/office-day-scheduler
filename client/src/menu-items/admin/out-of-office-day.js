// assets
import KeyboardArrowRightIcon from '@mui/icons-material/KeyboardArrowRight';
// constant
const icons = { KeyboardArrowRightIcon };

// ==============================|| OUT OF OFFICE DAY MENU ITEMS ||============================== //

const out_of_office_day = {
    id: 'out-of-office-day-group',
    type: 'group',
    children: [
        {
            id: 'out-of-office-day',
            title: 'Out of Office Day List',
            type: 'item',
            url: '/admin/out-of-office-day',
            icon: icons.KeyboardArrowRightIcon,
            breadcrumbs: false
        }
    ]
};

export default out_of_office_day;
