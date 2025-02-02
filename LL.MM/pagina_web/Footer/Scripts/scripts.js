document.addEventListener('DOMContentLoaded', function() {
    // Seleccionar el botón del menú y la lista
    const menuIcon = document.querySelector('.menu-icon');
    const menuList = document.querySelector('.navigation ul');

    // Agregar el evento click al botón
    menuIcon.addEventListener('click', function() {
        // Toggle la clase 'show' en la lista
        menuList.classList.toggle('show');
        
        // Opcional: Cambiar el texto del botón según el estado
        if (menuList.classList.contains('show')) {
            menuIcon.textContent = 'Cerrar menú';
        } else {
            menuIcon.textContent = 'Ver menú';
        }
    });
});