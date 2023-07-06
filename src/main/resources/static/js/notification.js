function closeNotification(notificationId) {
    const notification = document.getElementById(notificationId);
    if (notification) {
        setTimeout(function() {
            notification.style.opacity = '0';
            setTimeout(function() {
                notification.style.display = 'none';
            }, 100);
        }, 50); // Add the desired delay in milliseconds (2000 milliseconds = 2 seconds)
    }
}