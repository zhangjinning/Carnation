/*
Remove browser default action
 */
document.addEventListener('touchstart', function (ev) {
    if (ev.cancelable) {
        if (!ev.defaultPrevented) {
            ev.preventDefault();
        }
    }
}, false);
