fetch('leaderboard.csv')
.then(response => response.text())
.then(data => {
    const rows = data.split('\n');
    const tableBody = document.querySelector('tbody');

    rows.forEach(row => {
        const columns = row.split(';');

        const position = columns[0];
        const pseudo = columns[1];
        const score = columns[2];

        const newRow = document.createElement('tr');
        newRow.innerHTML = `
            <td>${position}</td>
            <td>${pseudo}</td>
            <td>${score}</td>
        `;

        tableBody.appendChild(newRow);
    });
});
