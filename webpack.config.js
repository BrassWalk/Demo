const path = require('path');

module.exports = {
    mode: "production",
    entry: './src/main/webapp/index.tsx',
    devtool: 'inline-source-map',
      module: {
        rules: [
          {
            test: /\.tsx?$/,
            use: 'ts-loader',
            exclude: /node_modules/
          },
           {
                  test: /\.css$/i,
                  use: ['style-loader', 'css-loader'],
                }
        ]
      },
    resolve: {
      extensions: [".ts", ".tsx", ".js", ".jsx"]
    },
  output: {
    filename: 'bundle.js',
    path: path.resolve(__dirname, 'dist')
  }
}
