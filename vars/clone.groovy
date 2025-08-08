def call(String url, String branch) {
    echo "Cloning repository: ${url} (branch: ${branch})"
    git branch: "${branch}", url: "${url}"
}
